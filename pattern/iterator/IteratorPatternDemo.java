package pattern.iterator;

/**
 * @description:
 * @author: HeZhe
 * @date: 2020-04-10 15:14
 **/
public class IteratorPatternDemo {
    public static void main(String[] args) {
        NameRepository namesRepository = new NameRepository();

        for(Iterator iter = namesRepository.getIterator(); iter.hasNext();){
            String name = (String)iter.next();
            System.out.println("Name : " + name);
        }
    }
}
