import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException, JAXBException {

        File file = new File("items.xml");
        Scanner scan = new Scanner(System.in);

        JAXBContext context = JAXBContext.newInstance(Items.class);
        Unmarshaller un = context.createUnmarshaller();
        Items itemData = (Items) un.unmarshal(file);

        List<Item> items = itemData.getItem();

        for(Item e: items){
            System.out.println("\nDataType : "+e.getDataType());
            System.out.println("Name : "+e.getName());
            System.out.println("Data : "+e.getData());
            System.out.println("Group : "+e.getGroup());
            System.out.println("Sub Categories : " + e.getItems());
            System.out.println("--------------------------");
        }

        System.out.println("'\n\n------------- Options ---------------");
        System.out.println("\n1. Search Items by Group");
        System.out.println("\n2. Modify Movie");
        int choice = scan.nextInt();
        scan.nextLine();

        if(choice == 1){
            System.out.println("\nEnter the group name you're searching for: ");
            String search = scan.nextLine();

            List<Item> filteredByGroup = items.stream()
                    .filter(i ->i.getGroup().equals(search))
                    .collect(Collectors.toList());

            filteredByGroup.forEach(System.out::println);

        }
        else if (choice == 2){
            System.out.println("\nEnter the name of the movie you would like to modify: ");
            String search = scan.nextLine();

            Optional<Item> item = items.stream()
                    .filter(x -> x.getName().equals(search))
                    .findFirst();

            System.out.println(item.toString());

        }

        else{
            System.out.println("You entered an invalid option!");
        }
    }
}
