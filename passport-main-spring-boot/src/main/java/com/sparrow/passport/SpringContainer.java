/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.sparrow.passport;

import com.sparrow.constant.SysObjectName;
import com.sparrow.container.Container;
import com.sparrow.container.impl.SparrowContainer;
import com.sparrow.passport.config.SpringContext;
import com.sparrow.utility.ConfigUtility;
import com.sparrow.utility.StringUtility;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;

public class SpringContainer extends SparrowContainer {
    private static Logger logger = LoggerFactory.getLogger(SparrowContainer.class);

    @Override public <T> T getBean(String beanName) {
        return (T) SpringContext.getContext().getBean(beanName);
    }

    @Override public <T> T getBean(SysObjectName objectName) {
        String beanName = objectName.name().toLowerCase();
        String defaultBeanName = StringUtility.toHump(beanName, "_");
        beanName = ConfigUtility.getValue(beanName, defaultBeanName);
        ApplicationContext container = SpringContext.getContext();
        if (container == null) {
            logger.error("container is null");
            return null;
        }
        return (T) container.getBean(beanName);
    }
}
