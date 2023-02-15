# Developing version (for simplicity of developing)

up:
		docker-compose -f docker-compose.yml up -d --build

down:
		docker-compose -f docker-compose.yml down -v

# Production version (with all the microservices)

up-prod:
		docker-compose -f docker-compose.prod.yml up -d --build

down-prod:
		docker-compose -f docker-compose.prod.yml down -v