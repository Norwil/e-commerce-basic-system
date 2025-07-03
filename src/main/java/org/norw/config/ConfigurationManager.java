package org.norw.config;

public class ConfigurationManager {
    private static ConfigurationManager instance;

    private String databaseUrl;
    private String apiKey;
    private double taxRate;

    private ConfigurationManager() {
        this.databaseUrl = "jdbc:mysql://localhost:3306/ecommerce";
        this.apiKey = "sk_test_123456789";
        this.taxRate = 0.08;
    }

    public static ConfigurationManager getInstance() {
        if (instance == null) {
            instance = new ConfigurationManager();
        }
        return instance;
    }

    public String getDatabaseUrl() {
        return databaseUrl;
    }

    public String getApiKey() {
        return apiKey;
    }

    public double getTaxRate() {
        return taxRate;
    }

    public void displayConfig() {
        System.out.println("Config - DB: " + databaseUrl + ", Tax: " + (taxRate * 100) + "%");
    }
}
