/*
Licensed to the Apache Software Foundation (ASF) under one or more
contributor license agreements.  See the NOTICE file distributed with
this work for additional information regarding copyright ownership.
The ASF licenses this file to You under the Apache License, Version 2.0
(the "License"); you may not use this file except in compliance with
the License.  You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
*/

package com.sparrow.passport.infrastructure.persistence;

import com.sparrow.constant.DateTime;
import com.sparrow.passport.infrastructure.RedisKey;
import com.sparrow.passport.repository.VisitorRepository;
import com.sparrow.utility.DateTimeUtility;
import org.springframework.data.redis.core.RedisTemplate;

import jakarta.inject.Inject;
import jakarta.inject.Named;

@Named
public class RedisVisitorRepository implements VisitorRepository {
    @Inject
    private RedisTemplate redisTemplate;

    @Override
    public Long getVisitorId() {
        long visitorNumber = redisTemplate.opsForValue().increment(RedisKey.VISITOR_ID);
        String mmdd = DateTimeUtility.getFormatTime(System.currentTimeMillis(), DateTime.FORMAT_MMDD);
        return Long.parseLong(mmdd + "" + visitorNumber);
    }
}
