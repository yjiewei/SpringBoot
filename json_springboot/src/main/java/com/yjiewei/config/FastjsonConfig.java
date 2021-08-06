package com.yjiewei.config;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

/**
 * 注意：对于你要取代的值，序列化控制只能控制返回值的类型，具体到内部的细节并不能直接控制
 *      比如map类型，内部的value为null不能被正确替换
 * @author yjiewei
 * @date 2021/8/6
 */
@Configuration
public class FastjsonConfig extends WebMvcConfigurationSupport {
    @Override
    protected void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        // 从我的测试情况发现，Fastjson会取代内置的Jackson配置，并且两个也可以共存
//        Iterator<HttpMessageConverter<?>> iterator = converters.iterator();
//        while(iterator.hasNext()){
//            HttpMessageConverter<?> converter = iterator.next();
//            if(converter instanceof MappingJackson2HttpMessageConverter){
//                //将springboot的jackson的消息转换器移除
//                iterator.remove();
//            }
//        }

        // 对于特定的配置以及作用效果不够清楚
        FastJsonHttpMessageConverter converter = new
                FastJsonHttpMessageConverter();
        FastJsonConfig config = new FastJsonConfig();
        config.setSerializerFeatures(
/*            // 保留map空的字段
            SerializerFeature.WriteMapNullValue,
            // 将String类型的null转成""
            SerializerFeature.WriteNullStringAsEmpty,
            // 将Number类型的null转成0
            SerializerFeature.WriteNullNumberAsZero,
            // 将List类型的null转成[]
            SerializerFeature.WriteNullListAsEmpty,
            // 将Boolean类型的null转成false
            SerializerFeature.WriteNullBooleanAsFalse,
            // 避免循环引用
            SerializerFeature.DisableCircularReferenceDetect */

            SerializerFeature.QuoteFieldNames,
            SerializerFeature.DisableCircularReferenceDetect,
            SerializerFeature.WriteEnumUsingToString,
            // SerializerFeature.WriteMapNullValue,// 这样就不会输出了，默认false
            SerializerFeature.WriteDateUseDateFormat
            // 这里需要明确那个类型的返回值，如果返回值是String，并且值为null，就不会显示
            // 但是，如果你的返回值是一个map，他就处理不了，还是会返回null，map中的字段也是不可控的
            // SerializerFeature.WriteNullStringAsEmpty

        );
        converter.setFastJsonConfig(config);
        converter.setDefaultCharset(Charset.forName("UTF-8"));
        List<MediaType> mediaTypeList = new ArrayList<>();
        // 解决中文乱码问题，相当于在Controller上的@RequestMapping中加了个属性produces = "application/json"
        mediaTypeList.add(MediaType.APPLICATION_JSON);
        converter.setSupportedMediaTypes(mediaTypeList);
        converters.add(converter);
    }
}
