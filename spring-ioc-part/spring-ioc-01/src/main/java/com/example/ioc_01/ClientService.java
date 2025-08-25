package com.example.ioc_01;

public class ClientService {
    private static ClientService clientService =new ClientService();

    private ClientService(){}
    public static ClientService createClientService(){
        return clientService;
    }
}
