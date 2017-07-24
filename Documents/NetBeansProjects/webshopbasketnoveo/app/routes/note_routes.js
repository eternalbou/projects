var ObjectID = require('mongodb').ObjectID;
module.exports = function (app, db) {
    // GET-запрос для получения списка продуктов
    app.get('/api/products/', (req, res) => {
        // агрегируем массив для того, чтобы избавиться от поля _id и применяем метод toArray
        db.collection('products').aggregate(
                [
                    {"$project": {id: "$id", name: "$name", description: "$description", price: "$price", _id: 0}
                    }
                ]
                ).toArray(function (err, result) {
            if (err) {
                res.send(err);
            } else {
                res.send(result);
            }
        });
    });
    // POST-запрос для добавления элемента в корзину
    app.post('/api/cart/', (req, res) => {
        const item = {quantity: req.body.quantity, product_id: req.body.product_id};
        // задаём возможные значения вводимых параметров
        if ((req.body.product_id === '1' || req.body.product_id === '2') && (req.body.quantity === '1' || req.body.quantity === '2' || req.body.quantity === '3' || req.body.quantity === '4' || req.body.quantity === '5' || req.body.quantity === '6' || req.body.quantity === '7' || req.body.quantity === '8' || req.body.quantity === '9' || req.body.quantity === '10')) {
            // проверяем с помощью методов find и count, существуют ли в корзине уже певрый и второй продукт
            if (req.body.product_id === '1') {
                db.collection('basket').find({'product_id': '1'}).count(function (err, result) {
                    if (err) {
                        res.send(err);
                    } else if (result > 0) {
                        db.collection('basket').find({'product_id': '1'}).forEach(function (doc) {
                            const details = {'_id': doc._id};
                            const change = (parseInt(doc.quantity, 10) + parseInt(req.body.quantity, 10)).toString();
                            const note = {'product_id': req.body.product_id, 'quantity': change};
                            // продукт 1 существует в корзине, поэтому, прибавляем указанное количество
                            db.collection('basket').update(details, note, (err, result) => {
                                if (err) {
                                    res.send({'error': 'An error has occurred'});
                                } else {
                                    res.send(note);
                                    // устанавливаем время очистки выбранного товара = 5 мин.
                                    setTimeout(function () {
                                        db.collection('basket').deleteOne(details);
                                    }, 300000);
                                }
                            });
                        });
                    } else {
                        // продукта 1 в корзине нет, поэтому, добавляем его; аналогично для продукта 2 в коде ниже
                        db.collection('basket').insert(item, (err, result) => {
                            if (err) {
                                res.send({'error': 'An error has occurred'});
                            } else {
                                res.send(result.ops[0]);
                                db.collection('basket').find({'product_id': '1'}).forEach(function (doc) {
                                    details = {'_id': doc._id};
                                    setTimeout(function () {
                                        db.collection('basket').deleteOne(details);
                                    }, 300000);
                                });
                            }
                        });
                    }
                });
            } else if (req.body.product_id === '2') {
                db.collection('basket').find({'product_id': '2'}).count(function (err, result) {
                    if (err) {
                        res.send(err);
                    } else if (result > 0) {
                        db.collection('basket').find({'product_id': '2'}).forEach(function (doc) {
                            const details = {'_id': doc._id};
                            const change = (parseInt(doc.quantity, 10) + parseInt(req.body.quantity, 10)).toString();
                            const note = {'product_id': req.body.product_id, 'quantity': change};
                            db.collection('basket').update(details, note, (err, result) => {
                                if (err) {
                                    res.send({'error': 'An error has occurred'});
                                } else {
                                    res.send(note);
                                    setTimeout(function () {
                                        db.collection('basket').deleteOne(details);
                                    }, 300000);
                                }
                            });
                        });
                    } else {
                        db.collection('basket').insert(item, (err, result) => {
                            if (err) {
                                res.send({'error': 'An error has occurred'});
                            } else {
                                res.send(result.ops[0]);
                            }
                        });
                    }
                });
            }
        } else {
            console.log('Invalid data parameters. Please, add quantity = 1-10 and product_id = 1-2');
        }
    });
    // DELETE-запрос для удаления одной единицы выбранного по _id товара. _id товара находится при выполнении GET ./api/cart
    app.delete('/api/cart/:id', (req, res) => {
        const id = req.params.id;
        const details = {'_id': new ObjectID(id)};
        db.collection('basket').find(details).forEach(function (doc) {
            if (doc.quantity === '1') {
                // удаляем продукт из корзины, если его 1 единица
                db.collection('basket').remove(details, (err, item) => {
                    if (err) {
                        res.send({'error': 'An error has occurred'});
                    } else {
                        res.send(id + ' deleted!');
                        setTimeout(function () {
                            db.collection('basket').deleteOne(details);
                        }, 300000);
                    }
                });
            } else {
                const id = req.params.id;
                const details = {'_id': new ObjectID(id)};
                const change = (parseInt(doc.quantity, 10) - 1).toString();
                const note = {'product_id': doc.product_id, 'quantity': change};
                // снижаем количество продукта в корзине, если его количество больше 1
                db.collection('basket').update(details, note, (err, result) => {
                    if (err) {
                        res.send({'error': 'An error has occurred'});
                    } else {
                        res.send(note);
                        setTimeout(function () {
                            db.collection('basket').deleteOne(details);
                        }, 300000);
                    }
                });
            }
        });
    });
    // GET-запрос для получения списка товаров в корзине
    app.get('/api/cart/', (req, res) => {
        // считаем стоимость групп товаров (sum)
        db.collection('basket').find({$or: [{'product_id': '2'}, {'product_id': '1'}]}).forEach(function (doc) {
            if (doc.product_id === '2') {
                const price2 = (parseInt(doc.quantity) * 150).toString();
                db.collection('basket').update({'product_id': '2'}, {$set: {'sum': price2}});
            } else if (doc.product_id === '1') {
                const price1 = (parseInt(doc.quantity) * 50).toString();
                db.collection('basket').update({'product_id': '1'}, {$set: {'sum': price1}});
            }

        });
        db.collection('basket').find({}).toArray(function (err, result) {
            if (err) {
                res.send(err);
            } else {
                res.send(result);
            }
        }
        );


    });
};
