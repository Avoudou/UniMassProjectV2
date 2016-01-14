package graphics3D;

import java.util.ArrayList;
import java.util.List;

import objectDefinitions.CargoSpaceIndividual;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.PerspectiveCamera;
import com.badlogic.gdx.graphics.VertexAttributes.Usage;
import com.badlogic.gdx.graphics.g3d.Environment;
import com.badlogic.gdx.graphics.g3d.Material;
import com.badlogic.gdx.graphics.g3d.Model;
import com.badlogic.gdx.graphics.g3d.ModelBatch;
import com.badlogic.gdx.graphics.g3d.ModelInstance;
import com.badlogic.gdx.graphics.g3d.attributes.BlendingAttribute;
import com.badlogic.gdx.graphics.g3d.attributes.ColorAttribute;
import com.badlogic.gdx.graphics.g3d.environment.DirectionalLight;
import com.badlogic.gdx.graphics.g3d.utils.MeshPartBuilder;
import com.badlogic.gdx.graphics.g3d.utils.ModelBuilder;
import com.badlogic.gdx.math.MathUtils;

public class CargoSpace3D extends Basic3DTest {

	private List<ModelInstance> instances;
	private CargoSpaceIndividual cargoSpace;
	private int GRID_MIN = 0;
	private int GRID_MAX_X = 0;
	private int GRID_MAX_Y = 0;
	private int GRID_MAX_Z = 0;

	public CargoSpace3D(CargoSpaceIndividual cargoSpace) {
		this.cargoSpace = cargoSpace;
		GRID_MAX_Y = cargoSpace.getCargoSpace().length - 1;
		GRID_MAX_X = cargoSpace.getCargoSpace()[0].length - 1;
		GRID_MAX_Z = cargoSpace.getCargoSpace()[0][0].length - 1;
	}

	@Override
	public void create() {
		Gdx.graphics.setDisplayMode(1000, 800, false);
		lights = new Environment();
		lights.set(new ColorAttribute(ColorAttribute.AmbientLight, 0.4f, 0.4f, 0.4f, 1f));
		lights.add(new DirectionalLight().set(0.8f, 0.8f, 0.8f, -1f, -0.8f, -0.2f));

		modelBatch = new ModelBatch();

		cam = new PerspectiveCamera(50, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		cam.position.set(30f, 40f, -20f);
		cam.lookAt(-10, 5, 30);
		cam.near = 1f;
		cam.far = 300f;
		cam.update();

		ModelBuilder modelBuilder = new ModelBuilder();

		List<Model> models = new ArrayList<Model>();
		instances = new ArrayList<ModelInstance>();
		// Gdx.gl.glEnable(GL20.GL_BLEND);
		ArrayList<Integer> cargoIdList= takeCubesID();
		ArrayList<Color>   colorIdMatch= fixCargoColor(cargoIdList);
		
		Model spaceBoarder= new Model();
		drawCargoSpace(modelBuilder, spaceBoarder, GRID_MAX_Y/2f, GRID_MAX_X/2f,GRID_MAX_Z/2f, Color.GREEN);

		for (float y = GRID_MIN; y <= GRID_MAX_Y; y += 1) {
			for (float x = GRID_MIN; x <= GRID_MAX_X; x += 1) {
				for (float z = GRID_MIN; z <= GRID_MAX_Z; z += 1) {

					if (cargoSpace.getCargoSpace()[(int) y][(int) x][(int) z] != 0) {
						
						drawCargoCube(modelBuilder, models, y, x, z, colorIdMatch.get(findIdIndex(cargoIdList, cargoSpace.getCargoSpace()[(int) y][(int) x][(int) z])));

					}
				}
			}
		}
		
	}

	private void drawCargoCube(ModelBuilder modelBuilder, List<Model> models, float x, float y, float z, Color cubeColor) {
		MeshPartBuilder builder;
		modelBuilder.begin();
		builder = modelBuilder.part("grid", GL20.GL_TRIANGLES, Usage.Position | Usage.Normal, new Material(ColorAttribute.createDiffuse(cubeColor)));
		// builder.box(x, y, z, 1f, 1f, 1f);
		builder.box(x, y, z, .9f, .9f, .9f);
		models.add(modelBuilder.end());

		instances.add(new ModelInstance(models.get(models.size() - 1)));
	}
	private void drawCargoSpace(ModelBuilder modelBuilder, Model model, float x, float y, float d, Color cubeColor) {
		MeshPartBuilder builder;
		modelBuilder.begin();
		Material mat = new Material();
		mat.set(new ColorAttribute(ColorAttribute.Diffuse, .8f, 0.4f, .4f, 1f));
		mat.set(new BlendingAttribute(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA, 0.4f));
		builder = modelBuilder.part("grid", GL20.GL_TRIANGLES, Usage.Position | Usage.Normal, mat);
		// builder.box(x, y, z, 1f, 1f, 1f);
		builder.box(x, y, d, GRID_MAX_Y+1, GRID_MAX_X+1	, GRID_MAX_Z+1);
		

		instances.add(new ModelInstance(modelBuilder.end()));
		// instances.add(new ModelInstance(modelBuilder.end()));
	}

	@Override
	public void render() {
		Gdx.gl.glEnable(GL20.GL_BLEND);
		Gdx.gl.glBlendFunc(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA);
		
		
		Gdx.gl.glViewport(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);
		
		modelBatch.begin(cam);
		for (ModelInstance instance : instances) {
			modelBatch.render(instance, lights);
		}
		modelBatch.end();
	}

	public ArrayList<Color> fixCargoColor(ArrayList<Integer> cargoIdList) {
		ArrayList<Color> colorList = new ArrayList<Color>();
		for (int i = 0; i < cargoIdList.size(); i++) {
			if (cargoIdList.get(i) % 10 == 0 ||cargoIdList.get(i) % 10 == 1) {
				colorList.add(new Color(MathUtils.random(0f,0.5f), 0.3f, 0.3f, 0f));
				
			}
			if (cargoIdList.get(i) % 10 == 2) {
				colorList.add(new Color(MathUtils.random(0f,0.5f), 0.7f, 0.7f, 0f));
			}
			if (cargoIdList.get(i) % 10 ==3) {
				colorList.add(new Color(0.5f, 0.4f, MathUtils.random(0f,0.5f), 0f));
			}
		}

		return colorList;
	}

	public ArrayList<Integer> takeCubesID() {
		ArrayList<Integer> cargoIds = new ArrayList<Integer>();
		for (int x = GRID_MIN; x <= GRID_MAX_Y; x += 1) {
			for (int y = GRID_MIN; y <= GRID_MAX_X; y += 1) {
				for (int z = GRID_MIN; z <= GRID_MAX_Z; z += 1) {
					int temp = cargoSpace.getCargoSpace()[ x][y][z];
					if ( !idFoundAlready(temp, cargoIds)) {
					//	System.out.println("added id");
						cargoIds.add(temp);
					}
				}
			}
		}

		return cargoIds;
	}

	private int findIdIndex(ArrayList<Integer> idList, int id) {
		for (int i = 0; i < idList.size(); i++) {
			if (id == idList.get(i)) {
				return i;
			}

		}
		return 9999999;
	}

	private boolean idFoundAlready(int id, ArrayList<Integer> aList) {
		for (int i = 0; i < aList.size(); i++) {
			if (id == aList.get(i)) {
				//System.out.println(id);
				return true;
			}
		}

		return false;

	}

}