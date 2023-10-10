package com.czff.spring.ioc.filter;

import org.springframework.core.io.Resource;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.ClassMetadata;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.TypeFilter;

import java.io.IOException;

/**
 * @author 疾风劲草
 * @date 2021/3/11 23:32
 * @description TODO
 */
public class MyTypeFilter implements TypeFilter {
    @Override
    public boolean match(MetadataReader metadataReader, MetadataReaderFactory metadataReaderFactory) throws IOException {
        AnnotationMetadata annotationMetadata = metadataReader.getAnnotationMetadata();
        ClassMetadata classMetadata = metadataReader.getClassMetadata();
        Resource resource = metadataReader.getResource();

        String className = classMetadata.getClassName();
        System.out.println("-----------------" + className);
        if (className.contains("Dao")) {
            return true;
        }
        return false;
    }
}
