/*
 * JBoss, Home of Professional Open Source
 * Copyright 2010, Red Hat Middleware LLC, and individual contributors
 * by the @authors tag. See the copyright.txt in the distribution for a
 * full listing of individual contributors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.jboss.seam.servlet.http;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.enterprise.util.Nonbinding;
import javax.inject.Qualifier;

/**
 * Qualifies injection points that should have their values fetched from
 * a corresponding HTTP request parameter (i.e., query string or form parameter).
 * 
 * <p>Example explicit usage, assuming a servlet path /book.jsf?id=3</p>
 * 
 * <pre>
 * &#064;Inject &#064;RequestParam(&quot;id&quot;)
 * private String bookId;</pre>
 * 
 * <p>Example implicit usage, assuming the same servlet path</p>
 * 
 * <pre>
 * &#064;Inject &#064;RequestParam
 * private String id;</pre>
 * 
 * <p>Example explicit usage with default value</p>
 * 
 * <pre>
 * &#064;Inject &#064;RequestParam(&quot;id&quot;) &#064;DefaultValue(&quot;1&quot;)
 * private String bookId;</pre>
 * 
 * <p>
 * Because the bean produced is dependent-scoped, use of this annotation on
 * class fields and bean properties is only safe for request-scoped beans. Beans
 * with longer scopes should wrap this bean in a provider and retrieve the value
 * on demand.
 * </p>
 * 
 * <pre>
 * &#064;Inject &#064;RequestParam(&quot;id&quot;)
 * private Instance&lt;String&gt; bookIdProvider;
 * 
 * ...
 * 
 * String bookId = bookIdProvider.get();</pre>
 * 
 * @author Nicklas Karlsson
 * @author <a href="mailto:dan.j.allen@gmail.com">Dan Allen</a>
 */
@Qualifier
@Retention(RUNTIME)
@Target( { FIELD, PARAMETER, METHOD })
public @interface RequestParam
{
   @Nonbinding
   public String value() default "";
}