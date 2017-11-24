package com.sdm.srsys.configuration;

import org.sitemesh.builder.SiteMeshFilterBuilder;
import org.sitemesh.config.ConfigurableSiteMeshFilter;

public class MySiteMeshFilter extends ConfigurableSiteMeshFilter {

	  @Override
	  protected void applyCustomConfiguration(SiteMeshFilterBuilder builder) {
//	            Map default decorator. This shall be applied to all paths if no other paths match.
	    builder.addDecoratorPath("/*", "/WEB-INF/jsp/default.jsp")
	           // Map decorators to path patterns. 
//	           .addDecoratorPath("/*.jsp", "/WEB-INF/views/default.jsp")
//	           // Map multiple decorators to the a single path.
//	           .addDecoratorPaths("/articles/*", "/views/article.jsp",
//	                                             "/views/two-page-layout.jsp", 
//	                                             "/views/common.jsp")
	           // Exclude path from decoration.
	           .addExcludedPath("/login")
	           .addExcludedPath("/register")
	           .addExcludedPath("/rest/*")
	           .addExcludedPath("*.pop");
	    
	    builder.setMimeTypes("text/html", "application/xhtml+xml", "application/vnd.wap.xhtml+xml");
	  }

	}
