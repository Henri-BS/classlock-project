export type Chapter = {
  id: number;
  title: string;
  description: string;
  image: string;
};

export type ChapterPage = {
  content: Chapter[];
  last: boolean;
  first: boolean;
  empty: boolean;
  totalPages: number;
  totalElements: number;
  numberOfElements: number;
  size: number;
  number: number;
};
