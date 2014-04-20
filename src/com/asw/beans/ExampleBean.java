package com.asw.beans;

import java.io.Serializable;

import javax.annotation.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 * Bean de ejemplo
 * @author noe
 *
 */
@ManagedBean(value="exampleBean")
@SessionScoped
public class ExampleBean implements Serializable{

	private static final long serialVersionUID = 5351411450603831858L;
	
	// bean de ejemplo

}
