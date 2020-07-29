declare i32 @printf(i8*, ...)
@.str_1 = private unnamed_addr constant [4 x i8] c"%f\0A\00"

define float @main() {
%1 = alloca float, align 4
store float 0x4016666660000000, float* %1, align 4, !tbaa !4
%2 = alloca float, align 4
store float 4.5e+14, float* %2, align 4, !tbaa !4
%3 = load float, float* %1, align 4
%4 = load float, float* %2, align 4
%5 = fadd float %3, %4
%6 = fpext float%5 to double
%7 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @.str_1, i64 0, i64 0),double %6)
%8 = load float, float* %1, align 4
%9 = load float, float* %2, align 4
%10 = fadd float %8, %9
ret float %10
}

