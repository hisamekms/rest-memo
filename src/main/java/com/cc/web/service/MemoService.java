/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cc.web.service;

import com.cc.domain.memo.Memo;
import com.cc.domain.memo.MemoRepository;
import com.cc.infra.web.service.CRUDService;
import java.util.List;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

/**
 *
 * @author ooyamashinnosuke
 */
@Path("memos")
public class MemoService extends CRUDService<MemoRepository, Memo, Integer> {

    public MemoService() throws InstantiationException, IllegalAccessException {
        super();
    }

    @POST
    @Override
    @Consumes({"application/xml", "application/json"})
    public void create(Memo entity) {
        super.create(entity);
    }

    @PUT
    @Override
    @Consumes({"application/xml", "application/json"})
    public void edit(Memo entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    @Override
    public void remove(@PathParam("id") Integer id) {
        super.remove(id);
    }

    @GET
    @Path("{id}")
    @Produces({"application/xml", "application/json"})
    @Override
    public Memo find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({"application/xml", "application/json"})
    public List<Memo> findAll() {
        return super.findAll();
    }

}
