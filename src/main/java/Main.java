
import java.io.IOException;
public class Main {
    private  static String CalculateArray(String length,String Array){
        String result="";
        String array[]=Array.split(" ");
        int sumPositive=0;
        int minEl=Integer.parseInt(array[0]);
        int minElPosition=0;
        int maxElPosition=0;
        int maxEl=Integer.parseInt(array[0]);
        int multiply=1;
        for(int i=0;i<array.length;i++){
            int el=Integer.parseInt(array[i]);
            if(el>0){
                sumPositive+=el;
            }
            if(el>maxEl){
                maxElPosition=i;
            }
            if(el<minEl){
                minElPosition=i;
            }
        }
        if(minElPosition<maxElPosition){
            for(int i=minElPosition+1;i<maxElPosition;i++){
                multiply*=Integer.parseInt(array[i]);
            }
        }else{
            for(int i=maxElPosition+1;i<minElPosition;i++){
                multiply*=Integer.parseInt(array[i]);
            }
        }
        result=sumPositive+" "+multiply;
        return result;
    }
    public static void main(String[] args) {
        try {
            String[] input = FileDao.readLinesFromFile();
            String sum_multiply = CalculateArray(input[0],input[1]);
            FileDao.writeStringToFile(sum_multiply);
        } catch (IOException | NullPointerException e) {
            System.err.println(e.toString());
        }

    }
}
