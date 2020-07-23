package rmitest.imp;

import rmitest.HelloRMIService;

public class HelloRMIServiceImp implements HelloRMIService {
    public String sayHi(String name) {
        return "Hi," + name;
    }
}
