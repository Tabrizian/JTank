package com;

import java.util.EventListener;

public interface CollisonListener extends EventListener {
	void goneOutOfPage(CollisionEvent event);
	void collided(CollisionEvent event); 
}

