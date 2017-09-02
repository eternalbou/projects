package controller;


import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.dao.CollectionDao;
import model.pojo.Collection;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Kirill
 */
public class CollectionController implements Controller {

    @Override
    public ModelAndView handleRequest(HttpServletRequest hsr, HttpServletResponse hsr1) throws Exception {
        ModelAndView mv = new ModelAndView("collection");
        try {
            List<Collection> lst = CollectionDao.layDS();
            mv.addObject("vinyls", lst);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mv;
    }
    
}
