package main;

import bean.Express;
import com.kkb.task010205.Views;
import data.ExpressData;


public class Main {
    private static Views v = new Views();
    private static ExpressData d = new ExpressData();
    public static void main(String[] args) {
        v.welcome();
        m:while (true){
            int menu = v.menu();
            switch (menu){
                case 0:
                    break m;
                case 1:
                    cClick();
                    break;
                case 2:
                    uClick();
                    break;
            }
        }
        v.bye();
    }

    private static void uClick() {
        int code = v.uMenu();
        Express e = d.findByCode(code);
        if(e==null){
            v.printNull();
        }else{
            v.success();
            v.printExpress(e);
            d.delete(e);
        }

    }

    private static void cClick() {
        int i = v.mMenu();
        switch (i){
            case 0:
                return;
            case 1:{
                Express e = v.insert();
                Express e2 = d.findByNumber(e.getNumber());
                if(e2 == null){
                    if(d.add(e)){
                        v.printExpress(e);
                    }
                }else {
                    v.expressExist();
                }

            }
                break;
            case 2:{
                String number = v.findByNumber();
                Express e =d.findByNumber(number);
                Express e2 = e;
                if( e==null){
                    v.printNull();
                }else{
                    v.printExpress(e);
                    v.update(e2);
                    d.update(e,e);
                    v.printExpress(e2);
                }
            }
                break;
            case 3:{
                String number = v.findByNumber();
                Express e = d.findByNumber(number);
                if(e==null){
                    v.printNull();
                }else{
                    v.printExpress(e);
                    int type = v.delete();
                    if(type==1){
                        d.delete(e);
                        v.success();
                    }
                }
            }
                break;
            case 4:{
                Express[][] data = d.findAll();
                v.printAll(data);
            }
                break;
        }
    }

}
