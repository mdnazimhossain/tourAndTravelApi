package com.saiful.restApi.entity;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CascadeType;


import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
public class HajjPackage extends BaseModel {

    private String name;
   private String type;

//    private String category;

    private String price;
    private String startDate;
    private String endDate;
    private String description;
    private String location;
    private String imageLink;


    @OneToMany
    private List<Booking> booking;








//    @OneToMany(mappedBy = "HajjPackage", cascade = CascadeType.ALL, orphanRemoval = true)
//    private List<Booking> bookings = new ArrayList<>();

//    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
//    @JoinTable(name = "Booking_HajjPackage",
//            joinColumns = {
//                    @JoinColumn(name = "id")
//            },
//            inverseJoinColumns = {
//                    @JoinColumn(name = "id")
//            }
//    )
//    private List<Booking> bookings = new ArrayList<>();

}
