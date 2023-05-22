package manufacture;

public class Manufacture1 extends AManufacture {

	@Override
	public int produce() {
		super.producePower = 8;
		return super.producePower;
	}

}
