import java.util.*;

public class Main {

    public static void main(String [] args) {
        //Переменная Текста
        String inText=  "Медленно минуты уплывают в даль, \n" +
                "Встречи с ними ты уже не жди. \n" +
                "И хотя нам прошлое немного жаль, \n" +
                "Лучшее, конечно, впереди. Впереди";

        // сплитем текст,чистим файл и создаем масив слов
        String [] masText = inText.replaceAll("(?u)[^\\pL ]","").toLowerCase().split(" ");

        //всего слов
        //System.out.println(inText);
        System.out.println("ВСЕГО ВВЕДЕНО СЛОВ "+ masText.length);

        //1 подсчитать количество различных слов в файле:
        Set<String> unikSLOV = new LinkedHashSet<>(Arrays.asList(masText));
        System.out.println("Количество различных слов: " + unikSLOV.size());

        //2 Выведите на экран список различных слов файла, отсортированный по возрастанию их длины
        // (компаратор по длние слова, потом по тексту)
        ArrayList<String> arrlist = new ArrayList<>(Arrays.asList(masText));
        Comparator<String> mycomparator = new Comparator<String>() {
            public int compare(String o1, String o2) {
                if (o1.length() != o2.length())
                    return o1.length() - o2.length();
                else return o1.compareTo(o2);
            }
        };
        Collections.sort(arrlist,mycomparator);
        System.out.println("Различные слова по возрастанию: " + new LinkedHashSet<>(arrlist));

        //3 Подсчитайте и выведите на экран сколько раз каждое слово встречается в файле:
        Map<String,Integer> mapa = new HashMap<>();

        for(String k : arrlist){
            if (mapa.containsKey(k)) {
                mapa.put(k, mapa.get(k) + 1);
            } else {
                mapa.put(k, 1);
            }
        }
        System.out.println("Количество встречается слов: " + mapa);

        //4 Выведите на экран все строки в обратном порядке:
        Collections.reverse(arrlist);
        System.out.println("Reverce: " + arrlist);

        //5 Реализуйте свой итератор для обхода списка в обратном порядке:
        ReverseIterator revIter = new ReverseIterator(arrlist);
        System.out.print("Обратный итератор списка Reverce : ");
        while (revIter.hasNext()){
            System.out.print(" " +revIter.next());
        }

        //6 Выведите на экран строки, номера которых задаются пользователем в произвольном порядке:
        ArrayList<String> arrlist1 = new ArrayList<>(Arrays.asList(masText));
        System.out.print("\n Введите номер элемента: ");
        Scanner scanner =new Scanner(System.in);
        int numStr = scanner.nextInt();

        if (numStr-1>=0 && numStr-1<= arrlist1.size()) {
            System.out.println(numStr);
            System.out.println(arrlist1.get(numStr-1));
        }else {
            System.out.println("Введенного Вами элемента, нет в тексте");
        }



    }
}
class ReverseIterator implements Iterator<String> {
    private List <String> list;
    private int counter;

    public ReverseIterator(List list) {
        this.list = list;
        counter = list.size();
    }

    @Override
    public boolean hasNext() {
        return counter > 0;
    }

    @Override
    public String next() {
        counter--;
        return list.get(counter);
    }
}
