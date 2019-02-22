/*
 * Copyright 2019
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.heron.spouts.kafka;

import com.twitter.heron.api.metric.IMetric;
import org.apache.kafka.common.Metric;

public class KafkaMetricDecorator<M extends Metric> implements IMetric<Object> {
    private M metric;

    KafkaMetricDecorator(M metric) {
        this.metric = metric;
    }

    @Override
    public Object getValueAndReset() {
        return metric.metricValue();
    }
}
