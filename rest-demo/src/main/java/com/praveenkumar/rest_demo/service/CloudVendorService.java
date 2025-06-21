package com.praveenkumar.rest_demo.service;

import com.praveenkumar.rest_demo.model.CloudVendor;

import java.util.List;

public interface CloudVendorService {
    String createCloudVendor(CloudVendor cloudVendor);
    String updateCloudVendor(CloudVendor cloudVendor);
    String deleteCloudVendor(String cloudVendorId);
    CloudVendor getCloudVendor(String cloudVendorId);
    List<CloudVendor> getAllCloudVendors();

    List<CloudVendor> getByVendorName(String amazon);
}
