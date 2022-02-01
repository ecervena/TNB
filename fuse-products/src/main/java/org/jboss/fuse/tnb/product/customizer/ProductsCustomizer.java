package org.jboss.fuse.tnb.product.customizer;

import org.jboss.fuse.tnb.common.config.TestConfiguration;

public abstract class ProductsCustomizer extends Customizer {
    @Override
    public void customize() {
        switch (TestConfiguration.product()) {
            case CAMEL_K:
                customizeCamelK();
                break;
            case CAMEL_QUARKUS:
                customizeQuarkus();
                break;
            case CAMEL_SPRINGBOOT:
                customizeSpringboot();
                break;
            default:
                throw new IllegalArgumentException("Implement a branch for new product in ProductsCustomizer");
        }
    }

    public abstract void customizeCamelK();

    public abstract void customizeQuarkus();

    public abstract void customizeSpringboot();
}
