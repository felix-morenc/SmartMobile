package com.example.tindershoppingapp.Service;

import com.example.tindershoppingapp.Interfaces.IClothing;
import com.example.tindershoppingapp.Module.Clothing;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class ClothingService implements IClothing {

    List<Clothing> clothes = new ArrayList<>();


    private void addShirtsToList(){
        Clothing redShirt = new Clothing("Shirt",12.52,"This is a red shirt","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQaeidMDgx-OMwzHOGhKwj-NSpjBUgUQBDR7PHfOkk2HyEXAV-pbElgv6_YOjk8wF4IGQE&usqp=CAU");
        Clothing blueShirt = new Clothing("Shirt",15.52,"This is a blue shirt","https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Ftse2.mm.bing.net%2Fth%3Fid%3DOIP.2-FncdtGP5RFaN-Mpo4cCAHaJQ%26pid%3DApi&f=1");
        clothes.add(redShirt);
        clothes.add(blueShirt);
    }

    @Override
    public Clothing GetClothing(int id) {
        addShirtsToList();

        for (int i =0; i < clothes.size(); i++)
        {
            if(id==1){
                return clothes.get(0);
            }
            else{
                return clothes.get(1);
            }
        }
        return null;
    }
}
