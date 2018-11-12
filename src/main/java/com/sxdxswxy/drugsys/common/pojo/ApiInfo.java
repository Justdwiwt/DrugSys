package com.sxdxswxy.drugsys.common.pojo;

import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;

import java.util.List;

public class ApiInfo {

    private static final Contact DEFAULT_CONTACT = new Contact("", "", "");
    private static final ApiInfo DEFAULT = null;
    private final String version;
    private final String title;
    private final String description;
    private final String termsOfServiceUrl;
    private final String license;
    private final String licenseUrl;
    private final Contact contact;
    private final List<VendorExtension> vendorExtensions;

    public ApiInfo(String version, String title, String description, String termsOfServiceUrl, String license, String licenseUrl, Contact contact, List<VendorExtension> vendorExtensions) {
        this.version = version;
        this.title = title;
        this.description = description;
        this.termsOfServiceUrl = termsOfServiceUrl;
        this.license = license;
        this.licenseUrl = licenseUrl;
        this.contact = contact;
        this.vendorExtensions = vendorExtensions;
    }

    public static Contact getDefaultContact() {
        return DEFAULT_CONTACT;
    }

    public static ApiInfo getDEFAULT() {
        return DEFAULT;
    }

    public String getVersion() {
        return version;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getTermsOfServiceUrl() {
        return termsOfServiceUrl;
    }

    public String getLicense() {
        return license;
    }

    public String getLicenseUrl() {
        return licenseUrl;
    }

    public Contact getContact() {
        return contact;
    }

    public List<VendorExtension> getVendorExtensions() {
        return vendorExtensions;
    }

}
