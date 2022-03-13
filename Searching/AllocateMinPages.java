public class AllocateMinPages { 
    
    public static void main(String args[]) 
    { 
        int arr[]={10,20,10,30};
        int n=arr.length;
        int k=2;
        
    	System.out.print(minPages(arr,n,k)); 
    } 
    
    public static boolean isFeasible(int arr[],int size,int stu, int ans){
        int req=1,sum=0;
        for(int i=0;i<size;i++){
            if(sum+arr[i]>ans){
                req++;
                sum=arr[i];
            }
            else{
                sum+=arr[i];
            }
        }
        return (req<=stu);
    }
    
    public static int minPages(int arr[],int size, int stu){
        int sum=0,mx=0;
        for(int i=0;i<size;i++){
            sum+=arr[i];
            mx=Math.max(mx,arr[i]);
        }
        int low=mx,high=sum,res=0;
        
        while(low<=high){
            int mid=(low+high)/2;
            if(isFeasible(arr,size,stu,mid)){
                res=mid;
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return res;
    } 
} 