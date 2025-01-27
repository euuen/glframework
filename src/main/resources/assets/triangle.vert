#version 430

layout (location = 0) in vec3 vertex;
uniform mat4 pmvMatrix;

void main() {
    gl_Position = pmvMatrix * vec4(vertex, 1);
//    if (gl_VertexID == 0){
//        gl_Position = vec4(1, 1, 0, 1);
//    }if (gl_VertexID == 1){
//        gl_Position = vec4(-1, -1, 0, 1);
//    }if (gl_VertexID == 2){
//        gl_Position = vec4(1, -1, 0, 1);
//    }
}