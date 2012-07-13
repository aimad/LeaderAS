/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lds.persistance;

import com.lds.vo.Element;
import java.util.List;

/**
 *
 * @author ELKAOUMI
 */
public interface ElementDao {

    public List getAllElement();

    public Element getElement(String id);

    public void update(Element element);

    public void insert(Element element);

    public void delete(String id);
}
