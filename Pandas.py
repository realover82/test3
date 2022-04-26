
# coding: utf-8

# In[1]:


#보통 판다스 쓸때는 import를 쓴다.
import pandas as pd

#파이썬는 범용적인 용도를 커버하기 위해 만들어진것.
#패키지라는 것은 범용적임에도 불구하고 개발자가 못 만든것을 다른 사람들이 만들어주면 그것을 패키지라는 시스템을 통해
#가져와서 쓰기 쉽도록 만든 시스템! 그 끌고 오는 기능이 import
#pd는 그냥 판다스 쓰기 기니까 줄여쓰는것.


# excel은 100메가 넘으면 쓰기가 어렵다. 데이터분석용으로는 적합하지 않음.
# 그래서 pandas는 가장 실용적으로 쓰이는 것.
# 데이터분석을 할 때 실제 업무시간의 70~80%는 판다스를 쓴다고 생각하면 된다.
# 
# 판다스는 인간의 기본적인 직관과 상식으로 돌아가는 것과는 거리가 좀 있다. 그래서 좀 어렵게 느껴짐.
# 일반인의 상식과 직관보다는 수학자의 상식과 직관으로 돌아간다고 보면됨.
# 판다스의 문법을 이해하고 있다면 그것으로 어마어마한 표현과 응용이 가능하다. 
# 파이썬보다 판다스를 배우는 시간이 훨씬 짧지만 그것으로 활용할수있는건 훨씬 많다.

# ## LOAD DATASET

# In[2]:


#경로(ex: data/train.csv)는 사용자 설정마다 다를 수 있음.
train=pd.read_csv("D:/user/python/train.csv", index_col="PassengerId")  
#index_col로 0에서 출발안하고 우리가 보기쉽게 PassengerId기준으로 정렬.
#train으로 설정.

print(train.shape) #shape라 하면 가로세로 나타냄. 그것을 프린트
train.head()


# # 행렬검색

# In[3]:


train["Survived"].head()
#Column을 가져오고 싶다 하면 대괄호 사용


# In[4]:


#Column을 여러개 갖고 오고 싶다라고 하면 대괄호를 두개

columns=["Sex", "Pclass", "Survived"]
#train[["Sex", "Pclass", "Survived"]].head()
train[columns].head()


# In[5]:


#row 가져오는 건 .loc[] 
#행 가져오는건 [] 열 가져오는건 .loc[]


# In[6]:


#loc==locate
train.loc[1]


# In[7]:


passenger_ids=[1,3,7,13]

#train.loc[[1,3,7,13]]
train.loc[passenger_ids]


# In[8]:


#Column과 Row를 동시에 적용하고 싶다면?

train.loc[1,"Sex"]


# In[9]:


train.loc[[1,3,7,13],["Pclass","Sex"]]  # Row, Column 순


# ## 색인

# In[10]:


#train["Sex"]=="male" (남자면 True, 여자면 False로 나옴) 궁금하면 해보든지?!
#이걸 train으로 다시 묶어주면 남자인 데이터만 나온다
train[train["Sex"]=="male"].head()  #head()는 앞에 다섯개만 나오는것.


# In[11]:


#판다스의 대괄호에는 세개가 있다.
#대괄호와 문자열이 들어가면 문자열에 해당하는 Column을 찾는다.
#대괄호와 리스트가 들어가면 여러개의 Column을 가져옴.
#대괄호를 거기다 한번 더 묶어주면 그 안의 리스트에 해당하는 것만 실행시킨다.
#이게 판다스의 대괄호의 세가지 기능

#한번더해보면
train[train["Fare"]>20].head()  #train 데이터에서 fare가 20보다 큰것만 뽑아내기


# In[12]:


train[train["Embarked"]=="C"].head()


# In[13]:


train[train["Embarked"]!="C"].head()


# In[14]:


(train["Embarked"]=="C").head()


# In[15]:


#NaN이라고 표시되어있는 건 Not a Number라는 것. NaN(Not a Number), null
train[train["Age"].isnull()].head() #age가 비어있는것만 뽑아내려면 .isnull
#isnull(): 비어있으면 True, 아니면 False


# In[16]:


train[train["Age"].notnull()].head() #age가 안비어있는건 notnull


# In[17]:


#or(|) (shift+대괄호 오른쪽버튼) or의 기능 in 판다스 (파이썬과 다르게!)
null_age=train["Age"].isnull()
null_fare=train["Fare"].isnull()

train[null_age | null_fare]  #age가 비어있거나 fare가 비어있으면 True, 아니면 False


# In[18]:


#and(&) (shift+7) and의 기능 in 판다스
train[null_age&null_fare]


# # 컬럼 추가&수정하기
# 추가하는것만 배워도 수정하는건 거의 같다

# In[19]:


#변수설정하듯이 하면 된다.
train["Category"]="Titanic"
train.head()

#끝에 Category라는 컬럼이 새로 생긴 것을 확인할 수 있다.


# In[20]:


#하나의 컬럼에 다른 값이 들어갈때의 조건은 "개수만 맞으면 들어간다."
train.shape


# In[21]:


#뭐가 되었든 891개만 되면 들어간다.
train["ID"]=range(891)
train.head()


# In[22]:


#1부터 891까지 레인지 설정하고 싶으면 역시
train["ID"]=range(1,892)
train.head()

#Id는 내가 모르고 잘못넣은것. 코드를 지워도 정보는 살아있다. 껐다켜야 사라짐 (Restart&RunAll 탭으로). 지금 해서 없어짐.


# In[23]:


train["FamilySize"]=train["SibSp"]+train["Parch"]+1
train[["SibSp","Parch","FamilySize"]].head()


# In[24]:


#조건별로 다르게 줄것.
train["Nationality_FR"]=train["Embarked"]=="C"
train["Nationality_UK"]=train["Embarked"]!="C"

train[["Embarked","Nationality_FR","Nationality_UK"]].head()


# In[26]:


#train.loc[train["Embarked"]=="C","Embarked"] :Embarked가 "C"인 사람들의 Embarked 컬럼만 보여주기

train.loc[train["Embarked"]=="C","Nationality"]="France" #Embarked가 C인 사람들의 Nationality를 France로 입력
train.loc[train["Embarked"]!="C","Nationality"]="England" #Embarked가 C가 아닌 사람들의 Nationality를 England로 입력

train[["Embarked", "Nationality"]].head()


# In[27]:


train["Age"].mean() #평균을 구하고 싶으면 .mean()


# In[29]:


#빈 값 채워넣기
mean_age=train["Age"].mean()
#평균나이를 mean_age로 설정.

train.loc[train["Age"].isnull(),"Age"]=mean_age  #Age가 비어있는 사람들의 "Age 컬럼을 mean_age 입력값으로 설정.

train.head(10)


# # csv로 저장하기

# In[30]:


train.to_csv("D:/user/python/train(modified).csv")  #modified는 새파일로 저장하는것

