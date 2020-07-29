declare i32 @printf(i8*, ...)
@.str_1 = private unnamed_addr constant [18 x i8] c"The Number is %d\0A\00"
@.str_2 = private unnamed_addr constant [4 x i8] c"HI\0A\00"

define void @main() {
%1 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([18 x i8], [18 x i8]* @.str_1, i64 0, i64 0),i32 4)
%2 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @.str_2, i64 0, i64 0))
ret void
}
