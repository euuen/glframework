#version 430

layout (location = 0) in vec3 vertex;
uniform mat4 pmvMatrix;

void main() {
    gl_Position = pmvMatrix * vec4(vertex, 1);
}