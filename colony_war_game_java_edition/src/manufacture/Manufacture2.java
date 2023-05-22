package manufacture;

public class Manufacture2 extends AManufacture {

	@Override
	public int produce() {
		super.producePower = 10;
		return super.producePower;
	}

}
