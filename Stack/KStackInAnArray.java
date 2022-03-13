/*
    * top[]: for storing the "tops" of each stack i.e if k(number of stacks)=3, then "top[]" size will be 3. top[i] means that at ith index of the top[] contains the index of last element of current stack. 
        Ex: size of top[] is 4 (0-3). Suppose at top[2] = 4. This means that the last item of second array is present at 4th position of the main array i.e, arr[4]
    * Also V need to utilize the space in the array efficiently(if there is space) and for this purpose V use "next[]". This array will store the next element of the stack
        Suppose V have inserted, 
            push(100, 0)
            push(200, 0)
            push(300, 0)
        these 3 elements into the stack 0. So the next array's [i] will store the previous element of the current stack i.e after pushing above 3 the stack will be
            300
            200
            100
        So the next of 300 will be 200, 200 => 100, 100 => -1. Or V can say that the next[] points to the previous item of the current stack
        The "next[]" serves 2 purposes
            1. It points to the previous element of the current element
            2. It also helps in finding the next free slots 
    * "freeTop": gives the free top of the stack
*/


public class KStackInAnArray {
    
    // defining 3 arrays
    int arr[];   
    int top[];   
    int next[];  
    int cap, numOfStacks; 
    int freeTop;

    KStackInAnArray(int numOfStacks, int cap){
        this.numOfStacks = numOfStacks; 
        this.cap = cap; 

        // initialising 3 arrays
        arr = new int[cap]; 
        top = new int[numOfStacks]; 
        next = new int[cap];
        
        // initialize all the tops as -1
        for (int i = 0; i < numOfStacks; i++){ 
            top[i] = -1; 
        }
        
        // initially whole array is a free stack, so V initialise the "freeTop" = 0
        freeTop = 0;
        
        // initialize the next array, as whole array is empty that's V R connecting the current element with the next element => this means that the current index is pointing to the next index(which is free slot after current index) 
        for (int i=0; i<cap-1; i++) {       
            next[i] = i+1; 
        }
        // as there is no free slot after the current index
        next[cap-1] = -1;

        // this initialisation is similar to the array implementation fo LL
    }

    /*
        * Order is important
        * Get the "freeTop" into "i", means that get the index which is empty. int i = freeTop;
        * Update the freeTop with the next available space   freeTop = next[i]; 
        * Update the prev top of the stack or update the "next[]" or V can say that for     current element point to the previous element of the current stack   next[i] = top[sn];
        * Update the top
        * push the element at idx "i"

        Pictorically:
            V have a stack and the peek element is pointing to the prev ele of it i.e
            stack: | 100 |
            and 100 is pointing to the prev ele of it, i.e -1  
    */
    void push(int item, int sn) { 
        if (isFull()) { 
            System.out.print("\nStack Overflow\n");
            return; 
        } 

        int i = freeTop;     
        freeTop = next[i]; 
        next[i] = top[sn]; 
        top[sn] = i;
        arr[i] = item; 
    } 
    
    /*
        Get the top
        update the top with the next[]
        update next[] with freeTop
        update freeTop
        
    */
    int pop(int sn)  { 
        if (isEmpty(sn)) { 
            System.out.print("\nStack Underflow\n"); 
            return Integer.MAX_VALUE; 
        }
    
        int i = top[sn]; 
        top[sn] = next[i];   
        next[i] = freeTop; 
        freeTop = i; 
        return arr[i]; 
    }

    boolean isFull() {
        return (freeTop == -1);  
    } 
  
    boolean isEmpty(int sn)  {  
        return (top[sn] == -1); 
    }

    public static void main (String[] args) {
	
	    int numOfStacks = 3, sizeOfArr = 10; 
        KStackInAnArray ks=new KStackInAnArray(numOfStacks, sizeOfArr); 
      
        ks.push(15, 2); 
        ks.push(45, 2); 
       
        ks.push(17, 1); 
        ks.push(49, 1); 
        ks.push(39, 1); 
       
        ks.push(11, 0); 
        ks.push(9, 0); 
        ks.push(7, 0); 
      
        System.out.println("Popped element from stack 2 is " + ks.pop(2) ); 
        System.out.println("Popped element from stack 1 is " + ks.pop(1) ); 
        System.out.println("Popped element from stack 0 is " + ks.pop(0) );   
	  
	}

}
