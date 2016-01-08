package graphics3D;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.*;
import com.badlogic.gdx.graphics.VertexAttributes.Usage;
import com.badlogic.gdx.graphics.g3d.*;
import com.badlogic.gdx.graphics.g3d.attributes.ColorAttribute;
import com.badlogic.gdx.graphics.g3d.environment.DirectionalLight;
import com.badlogic.gdx.graphics.g3d.utils.ModelBuilder;

import java.util.ArrayList;
import java.util.List;

import objectDefinitions.CargoSpaceIndividual;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.PerspectiveCamera;
import com.badlogic.gdx.graphics.VertexAttributes.Usage;
import com.badlogic.gdx.graphics.g3d.Environment;
import com.badlogic.gdx.graphics.g3d.Model;
import com.badlogic.gdx.graphics.g3d.ModelBatch;
import com.badlogic.gdx.graphics.g3d.ModelInstance;
import com.badlogic.gdx.graphics.g3d.attributes.ColorAttribute;
import com.badlogic.gdx.graphics.g3d.environment.DirectionalLight;
import com.badlogic.gdx.graphics.g3d.Material;
import com.badlogic.gdx.graphics.g3d.utils.MeshPartBuilder;
import com.badlogic.gdx.graphics.g3d.utils.ModelBuilder;
import com.badlogic.gdx.math.MathUtils;

/**
 /*** Copyright 2011 See AUTHORS file.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * See: http://blog.xoppa.com/basic-3d-using-libgdx-2/
 * 
 * @author Xoppa
 */

public class CargoSpace3D implements ApplicationListener {
	private Environment lights;
	private PerspectiveCamera cam;
	private ModelBatch modelBatch;
	private List<ModelInstance> instances;
	private CargoSpaceIndividual cargoSpace;
	private int GRID_MIN = 0;
    private int GRID_MAX_X = 0;
    private int GRID_MAX_Y = 0;
    private int GRID_MAX_Z = 0;
	
	
	
	
	public CargoSpace3D(CargoSpaceIndividual cargoSpace) {
			this.cargoSpace= cargoSpace;
			GRID_MAX_Y= cargoSpace.getCargoSpace().length-1;
			GRID_MAX_X = cargoSpace.getCargoSpace()[0].length-1;
			GRID_MAX_Z = cargoSpace.getCargoSpace()[0][0].length-1;
	}


	@Override
	public void create() {
		lights = new Environment();
		lights.set(new ColorAttribute(ColorAttribute.AmbientLight, 0.4f, 0.4f, 0.4f, 1f));
		lights.add(new DirectionalLight().set(0.8f, 0.8f, 0.8f, -1f, -0.8f, -0.2f));
		
		modelBatch = new ModelBatch();
		
		cam = new PerspectiveCamera(80, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		cam.position.set(30f, 16f, -20f);
		cam.lookAt(16,16,16);
		cam.near = 1f;
		cam.far = 300f;
		cam.update();
		
//        ModelBuilder modelBuilder = new ModelBuilder();
//        model = modelBuilder.createBox(5f, 5f, 5f, new Material(ColorAttribute.createDiffuse(Color.GREEN)),
//        Usage.Position | Usage.Normal);
//        instance = new ModelInstance(model);
        
        ModelBuilder modelBuilder = new ModelBuilder();
        MeshPartBuilder builder;
        
		List<Model> models = new ArrayList<Model>();
		instances = new ArrayList<ModelInstance>();

		for (float x = GRID_MIN; x <= GRID_MAX_Y; x += 1) {
			for (float y = GRID_MIN; y <= GRID_MAX_X; y += 1) {
				for (float z = GRID_MIN; z <= GRID_MAX_Z; z += 1) {
					
					if(cargoSpace.getCargoSpace()[(int) x][(int) y][(int) z]!=0 ){
						if(cargoSpace.getCargoSpace()[(int) x][(int) y][(int) z]%10==1||cargoSpace.getCargoSpace()[(int) x][(int) y][(int) z]%10==0){
					drawCargoCube(modelBuilder, models, x, y, z, new Color(0.6f, .7f, .7f, 0));
						}
						if(cargoSpace.getCargoSpace()[(int) x][(int) y][(int) z]%10==2){
							drawCargoCube(modelBuilder, models, x, y, z, new Color(0.3f, .7f, .9f, 0));
						}
						if(cargoSpace.getCargoSpace()[(int) x][(int) y][(int) z]%10==3){
							drawCargoCube(modelBuilder, models, x, y, z, new Color(0.9f, .4f, .2f, 0));
						}
						
					}
				}
			}
		}
		System.out.println("Done");

	}


	private void drawCargoCube(ModelBuilder modelBuilder, List<Model> models, float x, float y, float z,Color cubeColor) {
		MeshPartBuilder builder;
		modelBuilder.begin();
//		builder = modelBuilder.part("grid",GL20.GL_TRIANGLES,Usage.Position | Usage.Normal,new Material(ColorAttribute.createDiffuse(new Color((MathUtils.random(0, 1)+0.1f), MathUtils.random(0, 1)+0.1f, MathUtils.random(0, 1)+0.1f, 0))));
	
		builder = modelBuilder.part("grid",GL20.GL_TRIANGLES,Usage.Position | Usage.Normal,new Material(ColorAttribute.createDiffuse(cubeColor)));
		builder.setColor(Color.GREEN);
		builder.box(x, y, z, .9f, .9f, .9f);
		models.add(modelBuilder.end());

		instances.add(new ModelInstance(models.get(models.size() - 1)));
	}

	@Override
	public void render() {
        Gdx.gl.glViewport(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);
        
        modelBatch.begin(cam);
        for(ModelInstance instance : instances) {
        	modelBatch.render(instance, lights);
        }
        modelBatch.end();
	}
	
	@Override
	public void dispose() {
//		modelBatch.dispose();
//		model.dispose();
	}

	@Override
	public void resize(int width, int height) {
	}

	@Override
	public void pause() {
	}

	@Override
	public void resume() {
	}
}