package data;

import bean.Express;

import java.util.Random;

public class ExpressData {
    private Express[][] data = new Express[100][];
    private int size;
    {
        for(int i=0;i<10;i++){
            data[i]= new Express[10];
        }
    }

    private Random random = new Random();

    public boolean add(Express e){
        if(size == 100){
            return false;
        }
        int x=-1;
        int y=-1;
        while (true){
            x = random.nextInt(10);
            y = random.nextInt(10);
            if(data[x][y]==null){
                break;
            }
        }

        int code = randomCode();
        e.setCode(code);
        data[x][y] = e;
        return true;

    }

    private int randomCode(){
        while (true){
            int code = random.nextInt(900000)+100000;
            Express e = findByCode(code);
            if(e==null){
                return code;
            }
        }

    }

    public Express findByNumber(String number){
        Express e = new Express();
        e.setNumber(number);
        for(int i=0;i<10;i++){
            for (int j=0;j<10;j++){
                if (e.equals(data[i][j])){
                    return data[i][j];
                }
            }
        }
        return null;

    }

    public Express findByCode(int code){
        for(int i=0;i<10;i++){
            for(int j=0;j<10;j++){
                if(data[i][j]==null){
                    continue;
                }
                if(code==data[i][j].getCode()){
                    return data[i][j];
                }
            }
        }
        return null;
    }

    public void update(Express oe,Express ne){
        delete(oe);
        add(ne);
    }

    public void delete(Express e){
        for(int i=0;i<10;i++) {
            for (int j = 0; j < 10; j++) {
                if (e.equals(data[i][j])) {
                    data[i][j] = null;
                    break;
                }
            }
        }
    }

    public Express[][] findAll(){
        return data;
    }

}
