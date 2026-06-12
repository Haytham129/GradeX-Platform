package com.haytham.studenthub;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity
@Table(name = "students")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private Integer age;
    private Double gpa;

    @Transient
    private List<Integer>hours;

    public void calculateGpa(List<Double> points, List<Integer> hours){
        if (points == null || hours == null || points.isEmpty()  || points.size() != hours.size()) {
            this.gpa =0.0;
            return;
        }

        double sumPoints = 0;
        int sumHours = 0;

        for(int i = 0;i<points.size();i++){
            sumPoints+= points.get(i) * hours.get(i);
            sumHours += hours.get(i);
        }

    
    this.gpa =(sumHours == 0) ? 0.0 : sumPoints /sumHours;

    }private List<Double> points;

    public List<Double> getPoints() {
        // TODO Auto-generated method stub
        
    return this.points; // أو اللوجيك الخاص بحساب النقاط بناءً على الدرجات
}
    }
    
    
