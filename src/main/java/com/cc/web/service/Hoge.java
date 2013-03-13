/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cc.web.service;

import com.cc.domain.memo.Memo;
import com.cc.domain.memo.MemoRepository;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.slf4j.Logger;

/**
 *
 * @author ooyamashinnosuke
 */
@Stateless
@Path("/hoge")
public class Hoge {
    
    @Inject
    private Logger logger;
    @Inject
    private MemoRepository memoRepository;
    
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public String hoge(@PathParam("id") String id) {
        logger.info("start");
        List<Memo> list = memoRepository.findAll();
        logger.info(list.toString());
        logger.info("end");
        return id;
    }
}
