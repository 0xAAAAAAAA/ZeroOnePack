import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 主入口类
 *
 * @author Bullet
 * @time 2017-06-24 23:25
 */
public class Main {

  private static Goods[] allGoods = new Goods[] {
      new Goods(2, 6),
      new Goods(2, 3),
      new Goods(6, 5),
      new Goods(5, 4),
      new Goods(4, 6) };

  private static Pack pack = new Pack(10);

  private static List<PackLoader> packLoaders = new ArrayList<>();

  static {
    packLoaders.add(new AttributePackLoader(AttributePackLoader.smallSizePriorComparator));
    packLoaders.add(new AttributePackLoader(AttributePackLoader.bigSizePriorComparator));
    packLoaders.add(new AttributePackLoader(AttributePackLoader.valueToSizePriorComparator));
  }

  public static void main(String[] args) throws CloneNotSupportedException {
    showAllGoods(allGoods);
    System.out.println(pack);
    for (PackLoader pl: packLoaders) {
      System.out.println();
      System.out.println(pl.getClass().getName());
      pack(allGoods, pack, pl);
    }
  }

  private static void pack(Goods[] allGoods, Pack pack, PackLoader packLoader)
      throws CloneNotSupportedException {
    Goods[] newAllGoods = Arrays.copyOf(allGoods, allGoods.length);
    Pack newPack = new Pack(pack.size);
    newPack.fill(newAllGoods, packLoader);
    System.out.println(newPack);
    System.out.println("CurrentSize: " + newPack.getCurrentSize() + ", CurrentValue: " +newPack.getCurrentValue());
  }

  private static void showAllGoods(Goods[] allGoods) {
    StringBuilder sb = new StringBuilder();
    sb.append("[ ");
    for (Goods gs : allGoods) {
      sb.append(gs.toString() + ", ");
    }
    sb.append(" ]");
    System.out.println(sb.toString());
  }

}
