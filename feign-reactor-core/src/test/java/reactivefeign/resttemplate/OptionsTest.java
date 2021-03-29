/**
 * Copyright 2018 The Feign Authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
package reactivefeign.resttemplate;

import org.junit.Ignore;
import org.junit.Test;
import reactivefeign.ReactiveFeignBuilder;
import reactivefeign.resttemplate.client.RestTemplateFakeReactiveFeign;
import reactivefeign.resttemplate.client.RestTemplateReactiveOptions;
import reactivefeign.testcase.IcecreamServiceApi;
import reactor.core.scheduler.Scheduler;
import reactor.core.scheduler.Schedulers;

/**
 * @author Sergii Karpenko
 */
public class OptionsTest extends reactivefeign.OptionsTest {

  @Override
  protected ReactiveFeignBuilder<IcecreamServiceApi> builder(long readTimeoutInMillis) {
    return RestTemplateFakeReactiveFeign.<IcecreamServiceApi>builder().options(
            new RestTemplateReactiveOptions.Builder().setReadTimeoutMillis(readTimeoutInMillis).build());
  }

  @Override
  protected ReactiveFeignBuilder<IcecreamServiceApi> builder(boolean followRedirects) {
    return RestTemplateFakeReactiveFeign.<IcecreamServiceApi>builder().options(
            new RestTemplateReactiveOptions.Builder().setFollowRedirects(followRedirects).build());
  }

  //to not detect blocking calls
  @Override
  protected Scheduler testScheduler(){
    return Schedulers.elastic();
  }

  //It's to difficult to configure
  @Test
  @Override
  @Ignore
  public void shouldNotFollowRedirects(){

  }
}