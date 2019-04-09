import java.util.*;
public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int num = sc.nextInt();
            int[] arr = new int[num] ;
            for(int i = 0 ; i < num ; i++){
                arr[i] = sc.nextInt();
            }
            int flag = sc.nextInt();
            Arrays.sort(arr);
            if(flag==0){
                for(int i = 0 ; i< num ;i++){
                    System.out.print(arr[i]+" ");
                }
            }
            else if(flag==1){
                for(int i = num-1 ; i>=0 ;i--){
                    System.out.print(arr[i]+" ");
                }
            }
            else break;

        }
    }
}