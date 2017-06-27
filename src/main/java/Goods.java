/**
 * 商品
 *
 * @author Bullet
 * @time 2017-06-23 19:43
 */
public class Goods implements Cloneable{

  public int size;
  public int value;

  public Goods(int size, int value) {
    this.size = size;
    this.value = value;
  }

  public Goods() {
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    Goods goods = (Goods) o;

    if (size != goods.size) {
      return false;
    }
    return value == goods.value;
  }

  @Override
  public int hashCode() {
    int result = size;
    result = 31 * result + value;
    return result;
  }

  @Override
  public String toString() {
    return "Goods{" +
        "size=" + size +
        ", value=" + value +
        '}';
  }

  @Override
  protected Object clone() throws CloneNotSupportedException {
    return super.clone();
  }
}
