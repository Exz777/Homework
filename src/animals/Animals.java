package animals;

import animals.valid.NumberValid;
import java.util.Scanner;
import java.util.regex.Pattern;

public abstract class Animals {
    private String name = "";
    private int age = -1;
   private int weight = -1;
    private String color = "";
    private NumberValid numberValid = new NumberValid();

    public void setName(String name) {
        this.name = name;
    }
    private int getAgeWeightNumValid(Scanner scanner) {
        int data = -1;
        while (true) {
            String ageStr = scanner.next();
            if(numberValid.isNumber(ageStr, Pattern.compile("^\\d+$"))) {
                data = Integer.parseInt(ageStr);
                if(data > 30 || data <=0) {
                    System.out.println("Ошибка ввода. Повторите ввод:");
                    continue;
                }
                break;
            }
            System.out.println("Ошибка ввода. Повторите ввод:");
        }
      return data;

    }

    public void setAge(Scanner scanner)
    {
    this.age = this.getAgeWeightNumValid(scanner);
    }
    public void setWeight(Scanner scanner)
    {
    this.weight = this.getAgeWeightNumValid(scanner);
    }
    public void setColor(String color)
    {
        this.color = color;
    }
    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }
    public int getWeight() {
        return weight;
    }
    public String getColor() {
        return color;
    }

    @Override
    public String toString() {
     String yearPadez = getYearPadez();
     if(yearPadez == null){
       return "Ошибка ввода! Введите правильный возвраст";
        }
    return String.format("Привет меня зовут %s, мне %d %s, я вешу %d кг, мой цвет - %s",
     this.name,
     this.age,
     yearPadez,
     this.weight,
     this.color);
    }

   private String getYearPadez(){
        if(this.age < 0 || this.age > 30){
            return null;
        }
        if(this.age>= 11 && this.age <=19) {
            return "лет";
        }
        int ostatok = this.age%10;
        if(ostatok == 0 || ostatok >= 5) {
            return "лет";
        }
        if (ostatok == 1) {
            return "год";
        }
         return "года" ;
   }
}




