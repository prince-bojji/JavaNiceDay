package week1.exercises.submission.exercise3.jehan;

public class CustomCollection<E> {
    private E elements[];
    private int count;

    @SuppressWarnings("unchecked")
    public CustomCollection(int length) {
		elements = (E[]) new Object[length];
	}

    public void add(E element){
        //  if collection is full
        if(count == elements.length){
            //  create new a array (twice the size)
            @SuppressWarnings("unchecked")
            E newElements[] = (E[]) new Object[count * 2];

            // copy all the existing elements 
            for(int i = 0; i < count; i++){
                newElements[i] = elements[i];
            }

            // set 'elements' to this new array
            elements = newElements;
        }

        //  add new elements at the end
        elements[count++] = element;
    }

    //  get elements by index
    public E get(int index){
        return elements[index];
    }

    //  remove elements by index
    public void remove(int index){
        // validate the index
        if(index < 0 || index >= count) 
			throw new IllegalArgumentException();

        //  shift the elements to the left to fill the hole
		for(int i = index; i < count; i++) 
            elements[i] =  elements[i + 1];
        
        count--;
    }

    //  get count
    public int getCount(){
        return count;
    }
}
