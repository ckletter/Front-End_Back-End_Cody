import java.awt.*;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;

/******************************************************************************************
 *
 * Program:	ManyBallsViewDoubleBuffered
 * Created by: Z. Blickensderfer, 12/30/22
 *
 * Description:
 * This extends the front-end class ManyBallsView. It adds a buffer strategy,
 * which creates two separate Graphics objects running on separate threads:
 * while one is displayed, the other is being painted. Then, they swap places.
 * This multi-threading creates an animation that appears smoother.
 *
 *****************************************************************************************/

public class ManyBallsViewDoubleBuffered extends ManyBallsView{

	public ManyBallsViewDoubleBuffered(int width, int height, ArrayList<Ball> balls) {
		super(width, height, balls);
		createBufferStrategy(2);
	}

	@Override
	public void paint(Graphics g) {
		BufferStrategy bf = this.getBufferStrategy();
		if (bf == null)
			return;

		Graphics g2 = null;

		try {
			g2 = bf.getDrawGraphics();
			// myPaint does the actual drawing, as described in ManyBallsView
			super.paint(g2);
		}
		finally {
			// It is best to dispose() a Graphics object when done with it.
			g2.dispose();
		}

		// Shows the contents of the backbuffer on the screen.
		bf.show();

		//Tell the System to do the Drawing now, otherwise it can take a few extra ms until
		//Drawing is done which looks very jerky
		Toolkit.getDefaultToolkit().sync();
	}
}