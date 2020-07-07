import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

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
        String choice = scan.nextLine();

        if(choice == gr)


    }
}