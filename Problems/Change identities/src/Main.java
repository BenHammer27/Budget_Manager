class Person {
    String name;
    int age;
}

class MakingChanges {
    public static void changeIdentities(Person p1, Person p2) {
        String memoryName = p1.name;
        int memoryAge = p1.age;
        p1.name = p2.name;
        p1.age = p2.age;
        p2.name = memoryName;
        p2.age = memoryAge;
    }
}