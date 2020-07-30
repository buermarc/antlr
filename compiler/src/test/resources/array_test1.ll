declare i32 @printf(i8*, ...)
@.str_1 = private unnamed_addr constant [4 x i8] c"%d\0A\00"

define i32 @main() {
%array1 = alloca [10 x i32]
%array2 = getelementptr [10 x i32], [10 x i32]* %array1, i64 0, i64 0
store i32 1, i32* %array2, align 4
%array3 = getelementptr [10 x i32], [10 x i32]* %array1, i64 0, i64 0
%1 = load i32, i32* %array3
%2 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @.str_1, i64 0, i64 0),i32 %1)
ret i32 0
}
