import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 背包
 *
 * @author Bullet
 * @time 2017-06-23 20:19
 */
public class Pack implements Cloneable{

  public int size;
  public List<Goods> filler = new ArrayList<>();

  public void fill(Goods[] goods, PackLoader pl){
    pl.fill(this, goods);
  }

  public Pack(int size) {
    this.size = size;
  }

  @Override
  public String toString() {
    return "Pack{" +
        "size=" + size +
        ", filler=" + filler +
        '}';
  }

  @Override
  protected Object clone() throws CloneNotSupportedException {
    Pack newPack = (Pack) super.clone();
    Collections.copy(newPack.filler, this.filler);
    return newPack;
  }

  public int getCurrentSize() {
    int sum = 0;
    for (Goods gs : filler) {
      sum += gs.size;
    }
    return sum;
  }

  public int getCurrentValue() {
    int sum = 0;
    for (Goods gs : filler) {
      sum += gs.value;
    }
    return sum;
  }

}
