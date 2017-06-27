import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 按照属性比较直接装填到背包中
 *
 * @author Bullet
 * @time 2017-06-23 20:36
 */
public class AttributePackLoader implements PackLoader{

  public Comparator<Goods> attributeComparator;

  public AttributePackLoader(Comparator<Goods> attributeComparator) {
    this.attributeComparator = attributeComparator;
  }

  public static final Comparator<Goods> bigSizePriorComparator = new Comparator<Goods>() {
    @Override
    public int compare(Goods o1, Goods o2) {
      if (o1.size < o2.size) {
        return 1;
      } else if (o1.size == o2.size) {
        return 0;
      } else {
        return -1;
      }
    }
  };

  public static final Comparator<Goods> smallSizePriorComparator = new Comparator<Goods>() {
    @Override
    public int compare(Goods o1, Goods o2) {
      if (o1.size < o2.size) {
        return -1;
      } else if (o1.size == o2.size) {
        return 0;
      } else {
        return 1;
      }
    }
  };

  public static final Comparator<Goods> valueToSizePriorComparator = new Comparator<Goods>() {
    @Override
    public int compare(Goods o1, Goods o2) {
      if ((o1.value / (float) o1.size) < (o2.value / (float)o2.size)) {
        return -1;
      } else if ((o1.value / (float) o1.size) == (o2.value / (float)o2.size)) {
        return 0;
      } else {
        return 1;
      }
    }
  };


  @Override
  public void fill(Pack pack, Goods[] goods) {
    if (this.attributeComparator == null) {
      System.out.println("attributeComparator为null");
      return;
    }
    List<Goods> goodsList = new ArrayList<Goods>();
    for (Goods gs: goods) {
      try {
        goodsList.add((Goods) gs.clone());
      } catch (CloneNotSupportedException e) {
        e.printStackTrace();
      }
    }
    Collections.sort(goodsList, attributeComparator);
    int currentSize = 0;
    for (Goods gs: goodsList) {
      if (currentSize + gs.size > pack.size) {
        continue;
      } else {
        currentSize += gs.size;
        pack.filler.add(gs);
      }
    }
  }

}
